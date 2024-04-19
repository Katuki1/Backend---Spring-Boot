package com.microservice.departmentservice.model;

public record Employees(Long id, Long departmentId, String name, int age, String position) {
}
