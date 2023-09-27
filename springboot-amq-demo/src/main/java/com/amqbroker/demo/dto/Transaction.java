package com.amqbroker.demo.dto;

public record Transaction(String accountNumber, int amount, String remark) {
}
