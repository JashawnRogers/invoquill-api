package com.jashawnbuilds.invoquill_api.shared.infrastructure.config;

import com.jashawnbuilds.invoquill_api.shared.adapter.out.persistence.converter.EmailAddressReadConverter;
import com.jashawnbuilds.invoquill_api.shared.adapter.out.persistence.converter.EmailAddressWriteConverter;
import com.jashawnbuilds.invoquill_api.shared.adapter.out.persistence.converter.UsPhoneNumberReadConverter;
import com.jashawnbuilds.invoquill_api.shared.adapter.out.persistence.converter.UsPhoneNumberWriteConverter;
import com.jashawnbuilds.invoquill_api.tenant.adapter.out.persistence.tenant.converter.BusinessNameReadConverter;
import com.jashawnbuilds.invoquill_api.tenant.adapter.out.persistence.tenant.converter.BusinessNameWriteConverter;
import com.jashawnbuilds.invoquill_api.tenant.adapter.out.persistence.tenant.converter.CompanyCodeReadConverter;
import com.jashawnbuilds.invoquill_api.tenant.adapter.out.persistence.tenant.converter.CompanyCodeWriteConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;

import java.util.List;

@Configuration
public class JdbcConfiguration {

    @Bean
    JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(
                List.of(
                        new BusinessNameReadConverter(),
                        new BusinessNameWriteConverter(),
                        new CompanyCodeReadConverter(),
                        new CompanyCodeWriteConverter(),
                        new EmailAddressReadConverter(),
                        new EmailAddressWriteConverter(),
                        new UsPhoneNumberReadConverter(),
                        new UsPhoneNumberWriteConverter()
                )
        );
    }
}
