package com.krigersv.models;

import lombok.Data;

@Data
public class CreateUserIdResponseModel {
    private int id;
    private String name, job, createdAt;
}
