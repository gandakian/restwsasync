package com.amirbhujel.rest;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

public class CheckProcessorImpl {

	@POST
	@Path("/checks")
	public void processChecks(@Suspended final AsyncResponse response, final ChecksList checks) {

		new Thread() {
			public void run() {

				if (checks.getChecks() == null || checks.getChecks().size() == 0) {
					response.resume(new BadRequestException());
				}
				response.resume(true);
			}
		}.start();
	}
}
