package com.oxygen.education.service;

public interface TestService {
    String testSave(String phone, String password);

    void printHeader();

    void execute(Long companyId, Long userId, String phone);

    void executeV2(String phone);

    void asyncExecute(String phone) throws InterruptedException;
}
