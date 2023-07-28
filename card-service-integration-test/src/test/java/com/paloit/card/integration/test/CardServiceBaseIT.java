package com.paloit.card.integration.test;

import com.paloit.card.client.CardServiceClient;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith({SpringExtension.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CardServiceBaseIT {
    @Autowired
    protected CardServiceClient client;
}