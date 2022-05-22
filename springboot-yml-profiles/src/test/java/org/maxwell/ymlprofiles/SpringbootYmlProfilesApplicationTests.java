package org.maxwell.ymlprofiles;

import org.junit.jupiter.api.Test;
import org.maxwell.ymlprofiles.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;

@SpringBootTest
class SpringbootYmlProfilesApplicationTests {

    @Autowired
    private Company company;


    @Test
    void contextLoads() {

        System.out.println(company);
    }

}
