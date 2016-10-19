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
package org.restcomm.connect.telephony.api;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Currency;

import javax.servlet.sip.SipServletRequest;
import javax.servlet.sip.SipServletResponse;

import org.joda.time.DateTime;
import org.restcomm.connect.commons.annotations.concurrency.Immutable;
import org.restcomm.connect.commons.configuration.RestcommConfiguration;
import org.restcomm.connect.commons.dao.Sid;

/**
 * @author quintana.thomas@gmail.com (Thomas Quintana)
 * @author jean.deruelle@telestax.com
 */
@Immutable
public final class CallInfo {
    private final Sid sid;
    private final Sid instanceSid;
    private final Sid accountSid;
    private CallStateChanged.State state;
    private final CreateCall.Type type;
    private final String direction;
    private final DateTime dateCreated;
    private final DateTime dateConUpdated;
    private final String forwardedFrom;
    private final String fromName;
    private final String from;
    private final String to;
    private final SipServletRequest invite;
    private final SipServletResponse lastResponse;
    private final boolean webrtc;
    private boolean muted;
    builder.setCallerName(name);
    builder.setStartTime(new DateTime());
    String fromString = (from.getUser() != null ? from.getUser() : "CALLS REST API");
    builder.setFrom(fromString);
    // builder.setForwardedFrom(callInfo.forwardedFrom());
    // builder.setPhoneNumberSid(phoneId);
    builder.setStatus(external.name());
    builder.setDirection("outbound-api");
    builder.setApiVersion(apiVersion);
    builder.setPrice(new BigDecimal("0.00"));
    // TODO implement currency property to be read from Configuration
    builder.setPriceUnit(Currency.getInstance("USD"));
    final StringBuilder buffer = new StringBuilder();
    buffer.append("/").append(apiVersion).append("/Accounts/");
    buffer.append(accountId.toString()).append("/Calls/");
    buffer.append(id.toString());
    final URI uri = URI.create(buffer.toString());
    builder.setUri(uri);
    builder.setCallPath(self().path().toString());
    builder.setParentCallSid(parentCallSid);
    public CallInfo(final Sid sid, final CallStateChanged.State state, final CreateCall.Type type, final String direction,
                    final DateTime dateCreated, final String forwardedFrom, final String fromName, final String from, final String to,
                    final SipServletRequest invite, final SipServletResponse lastResponse, final boolean webrtc, final boolean muted, final DateTime dateConUpdated) {
        super();
        this.sid = sid;
        this.state = state;
        this.direction = direction;
        this.dateCreated = dateCreated;
        this.forwardedFrom = forwardedFrom;
        this.fromName = fromName;
        this.from = from;
        this.to = to;
        this.invite = invite;
        this.lastResponse = lastResponse;
        this.dateConUpdated = dateConUpdated;
        this.type = type;
        this.webrtc = webrtc;
        this.muted = muted;
    }

    public DateTime dateCreated() {
        return dateCreated;
    }

    public DateTime dateConUpdated() {
        return dateConUpdated;
    }

    public String direction() {
        return direction;
    }

    public CreateCall.Type type() {
        return type;
    }

    public String forwardedFrom() {
        return forwardedFrom;
    }

    public String fromName() {
        return fromName;
    }

    public String from() {
        return from;
    }

    public Sid sid() {
        return sid;
    }

    public CallStateChanged.State state() {
        return state;
    }

    public void setState(CallStateChanged.State state) {
        this.state = state;
    }

    public String to() {
        return to;
    }

    public SipServletRequest invite() {
        return invite;
    }

    public SipServletResponse lastResponse() {
        return lastResponse;
    }

    public boolean isWebrtc() {
        return webrtc;
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMute(boolean muted) {
        this.muted = muted;
    }

}
