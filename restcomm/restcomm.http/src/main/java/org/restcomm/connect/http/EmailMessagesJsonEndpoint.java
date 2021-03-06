/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2014, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */
package org.restcomm.connect.http;

import org.restcomm.connect.commons.annotations.concurrency.ThreadSafe;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

/**
 * @author quintana.thomas@gmail.com (Thomas Quintana)
 */
@Path("/Accounts/{accountSid}/Email/Messages.json")
@ThreadSafe
public final class EmailMessagesJsonEndpoint extends EmailMessagesEndpoint {
    public EmailMessagesJsonEndpoint() {
        super();
    }

    @POST
    public Response putEmailMessage(@PathParam("accountSid") final String accountSid, final MultivaluedMap<String, String> data) {
        return putEmailMessage(accountSid, data, APPLICATION_JSON_TYPE);
    }
}
