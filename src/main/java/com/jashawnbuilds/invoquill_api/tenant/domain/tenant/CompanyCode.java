package com.jashawnbuilds.invoquill_api.tenant.domain.tenant;

import java.util.Random;

public record CompanyCode(String value) {

    private static final int MAX_CHARS_OF_NAME_FOR_SNIPPET = 4;

    public CompanyCode {
        if (value == null || value.isBlank())
            throw new RuntimeException();
    }


    public static CompanyCode generateFrom(BusinessName businessName) {
        Random random = new Random();
        String businessNameStr = businessName.value();
        int businessNameLength = businessNameStr.length();
        int randomNumber = random.nextInt(10000);

        int minNumOfChars = Math.min(MAX_CHARS_OF_NAME_FOR_SNIPPET, businessNameLength);
        String businessNameSnippet = businessNameStr.substring(0, minNumOfChars).toUpperCase();
        String formattedNumber = String.format("%04d", randomNumber);

        String companyCode = businessNameSnippet.concat("_").concat(formattedNumber);
        return new CompanyCode(companyCode);
    }

    public static CompanyCode fromExisting(String existingCompanyCode) {
        return new CompanyCode(existingCompanyCode);
    }
}
