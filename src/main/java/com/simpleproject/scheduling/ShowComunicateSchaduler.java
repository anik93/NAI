package com.simpleproject.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ShowComunicateSchaduler {

	private static final Logger LOG = LoggerFactory.getLogger(ShowComunicateSchaduler.class);

	@Scheduled(fixedRate = 1000)
	public void showComunicate() {
		LOG.error("fixedRate = 1000");
	}

	@Scheduled(cron = "*/10 * * * * *")
	public void cronComunicate() {
		LOG.error("cron = \"*/10 * * * * *\"");
	}
}
