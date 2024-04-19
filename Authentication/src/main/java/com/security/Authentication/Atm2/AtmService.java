package com.security.Authentication.Atm2;

import co.ke.emtechhouse.Atm2.Validation.RESPONSEMESSAGES;
import co.ke.emtechhouse.Atm2.Validation.ValidatorService;
import co.ke.emtechhouse.Atm2.dto.ResponseDto;
import co.ke.emtechhouse.Utils.HttpInterceptor.EntityRequestContext;
import co.ke.emtechhouse.Utils.HttpInterceptor.UserRequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Slf4j
@Service
public class AtmService {
//    @Autowired
//    private ResponseDto responseDto;
    @Autowired
    private final AtmRepository atmRepository;
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private ValidatorService validatorService;

    public AtmService(AtmRepository atmRepository, ModelMapper modelMapper) {

        this.atmRepository = atmRepository;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<?> addAtm(Atm atm) {
        try {
            if (UserRequestContext.getCurrentUser().isEmpty()) {
                EntityResponse response = new EntityResponse();
                response.setMessage("User Name not present in the Request Header");
                response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
                response.setEntity("");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                if (EntityRequestContext.getCurrentEntityId().isEmpty()) {
                    EntityResponse response = new EntityResponse();
                    response.setMessage("Entity not present in the Request Header");
                    response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
                    response.setEntity("");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    Optional<Atm> atm1 = atmRepository.findById(atm.getId());
                    if (atm1.isPresent()) {
                        EntityResponse response = new EntityResponse();
                        response.setMessage("Atm Exists");
                        response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
                        response.setEntity("");
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    } else {
                        atm.setEntityId(EntityRequestContext.getCurrentEntityId());
                        atm.setPostedBy(UserRequestContext.getCurrentUser());
                        atm.setVendorName("");
                        atm.setPostedFlag('Y');
                        atm.setModifiedFlag('N');
                        atm.setVerifiedFlag('N');
                        atm.setDeletedFlag('N');
                        atm.setRejectedFlag('N');
                        atm.setPostedTime(new Date());
                        atm.setModifiedTime(new Date());
                        atm.setVerifiedTime(new Date());
                        atm.setDeletedTime(new Date());
                        atm.setRejectAt(new Date());
                        atm.setModifiedBy(UserRequestContext.getCurrentUser());
                        atm.setDeletedBy(UserRequestContext.getCurrentUser());
                        atm.setRejectBy(UserRequestContext.getCurrentUser());

                        atmRepository.save(atm);
                        EntityResponse response = new EntityResponse();
                        response.setMessage("ATM WITH ID NUMBER: " + " " + atm.getId() + " " + "CREATED SUCCESSFULLY" + " " + "AT" + " " + atm.getPostedTime());
                        response.setStatusCode(HttpStatus.CREATED.value());
                        response.setEntity(atm);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    }

                }
            }
        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }

    public List<ResponseDto> getAtms() {
        try {
            List<Atm> atms = atmRepository.findByDeletedFlag('N');

            return atms.stream()
                    .map(this::convertToResponseDto)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }
    private ResponseDto convertToResponseDto(Atm atm) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setAtmAccount(atm.getAtmAccount());
        responseDto.setBranchName(atm.getBranchName());
        responseDto.setProfileName(atm.getProfileName());
        responseDto.setTerminalId(atm.getTerminalId());
        responseDto.setLocation(atm.getLocation());
        responseDto.setCoordinates(atm.getCoordinates());
        return responseDto;
    }


    public EntityResponse<List<ResponseDto>> listAllAtms() {
        try {
            EntityResponse userValidator = validatorService.userValidator();
            if (userValidator.getStatusCode().equals(HttpStatus.NOT_ACCEPTABLE.value())) {
                return userValidator;
            } else {
                List<Atm> atms = atmRepository.findByDeletedFlag('N');
                EntityResponse listChecker = validatorService.listLengthChecker(atms);
                return (EntityResponse<List<ResponseDto>>) atms.stream()
                        .map(this::convertToResponseDto)
                        .collect(Collectors.toList());
//                return listChecker;
            }
        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }

    public EntityResponse<?> permanentDelete(String terminalId) {
        try {
            EntityResponse userValidator = validatorService.userValidator();
            if (userValidator.getStatusCode().equals(HttpStatus.NOT_ACCEPTABLE.value())) {
                return userValidator;
            } else {
                Optional<Atm> atm = atmRepository.findByTerminalId(terminalId);
                if (atm.isPresent()) {
                    Atm existingAtm = atm.get();
                    atmRepository.delete(existingAtm);

                    EntityResponse response = new EntityResponse();
                    response.setMessage("Deleted successfully");
                    response.setStatusCode(HttpStatus.OK.value());
                    response.setEntity("");
                    return response;
                } else {
                    EntityResponse response = new EntityResponse();
                    response.setMessage(RESPONSEMESSAGES.RECORDS_NOT_FOUND);
                    response.setStatusCode(HttpStatus.NOT_FOUND.value());
                    response.setEntity("");
                    return response;
                }
            }
        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }


    public EntityResponse<?> delete(String terminalId) {
        try {
            EntityResponse response = new EntityResponse();
            EntityResponse userValidator = validatorService.userValidator();
            if (userValidator.getStatusCode().equals(HttpStatus.NOT_ACCEPTABLE.value())) {
                return userValidator;
            } else {
                Optional<Atm> deleteAtm = atmRepository.findByTerminalId(terminalId);
                if (deleteAtm.isPresent()) {
                    if (deleteAtm.get().getDeletedFlag().equals('Y')) {
                        response.setMessage("Atm With Terminal Id " + deleteAtm.get().getTerminalId() + " Already Deleted On " + deleteAtm.get().getDeletedTime());
                        response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
                        response.setEntity("");
                        return response;
                    } else {
                        Atm existingAtm = deleteAtm.get();
                        existingAtm.setDeletedFlag('Y');
                        existingAtm.setDeletedBy(UserRequestContext.getCurrentUser());
                        existingAtm.setDeletedTime(new Date());
                        Atm deleted = atmRepository.save(existingAtm);

                        response.setMessage("Atm With Terminal Id " + existingAtm.getTerminalId() + " Deleted Successfully At " + existingAtm.getDeletedTime());
                        response.setStatusCode(HttpStatus.OK.value());
                        response.setEntity("");
                        return response;
                    }
                }else{
                        response.setMessage(RESPONSEMESSAGES.RECORDS_NOT_FOUND);
                        response.setStatusCode(HttpStatus.NOT_FOUND.value());
                        response.setEntity("");
                        return response;
                    }
                }

        }catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }

}

