package com.security.Authentication.Atm2.Validation;

import co.ke.emtechhouse.Atm2.EntityResponse;
import co.ke.emtechhouse.Utils.HttpInterceptor.EntityRequestContext;
import co.ke.emtechhouse.Utils.HttpInterceptor.UserRequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class ValidatorService {

    //TODO: USER VALIDATOR
    public EntityResponse<UserRequestContext> userValidator(){

        try{
            log.info("<============ User validation ===================>");
            if (UserRequestContext.getCurrentUser().isEmpty()) {
                EntityResponse response = new EntityResponse();
                response.setMessage("User Name not present in the Request Header");
                response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
                response.setEntity("");
                return response;
            }else {
                if (EntityRequestContext.getCurrentEntityId().isEmpty()) {
                    EntityResponse response = new EntityResponse();
                    response.setMessage("Entity not present in the Request Header");
                    response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
                    response.setEntity("");
                    return response;
                }else {
                    EntityResponse response = new EntityResponse();
                    response.setMessage("---User Present------");
                    response.setStatusCode(200);
                    response.setEntity("");
                    return response;
                }
            }
        }catch (Exception e){
            log.info("Caught Error {}"+e);
            return null;
        }
    }

    //TODO: CHECK IF A LIST HAS ITEMS
    public EntityResponse<?> listLengthChecker(List<?> list){
        try{
            Integer length= list.size();
            if(length>0){
                EntityResponse response = new EntityResponse();
                response.setMessage("Records Found");
                response.setStatusCode(HttpStatus.FOUND.value());
                response.setEntity(list);
                return response;
            }else {
                EntityResponse response = new EntityResponse();
                response.setMessage(RESPONSEMESSAGES.RECORDS_NOT_FOUND);
                response.setStatusCode(HttpStatus.NOT_FOUND.value());
                response.setEntity("");
                return response;
            }
        }catch (Exception e){
            log.info("Caught Error {}"+e);
            return null;
        }
    }
}
