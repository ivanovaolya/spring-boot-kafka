package com.educational.springbootkafka.controller.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author ivanovaolyaa
 * @version 11/13/2018
 */
@Data
public class Message {

    private String payload;

    private Date date;

}
