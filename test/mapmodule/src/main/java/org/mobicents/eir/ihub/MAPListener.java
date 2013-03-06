/*
 * TeleStax, Open Source Cloud Communications  Copyright 2012.
 * and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.eir.ihub;

import org.apache.log4j.Logger;
import org.mobicents.protocols.ss7.map.api.MAPDialog;
import org.mobicents.protocols.ss7.map.api.MAPDialogListener;
import org.mobicents.protocols.ss7.map.api.MAPMessage;
import org.mobicents.protocols.ss7.map.api.dialog.MAPAbortProviderReason;
import org.mobicents.protocols.ss7.map.api.dialog.MAPAbortSource;
import org.mobicents.protocols.ss7.map.api.dialog.MAPNoticeProblemDiagnostic;
import org.mobicents.protocols.ss7.map.api.dialog.MAPRefuseReason;
import org.mobicents.protocols.ss7.map.api.dialog.MAPUserAbortChoice;
import org.mobicents.protocols.ss7.map.api.errors.MAPErrorMessage;
import org.mobicents.protocols.ss7.map.api.errors.MAPErrorMessageFactory;
import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.MAPExtensionContainer;
import org.mobicents.protocols.ss7.map.api.service.mobility.MAPServiceMobilityListener;
import org.mobicents.protocols.ss7.map.api.service.mobility.authentication.SendAuthenticationInfoRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.authentication.SendAuthenticationInfoResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.imei.CheckImeiRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.imei.CheckImeiResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.CancelLocationRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.CancelLocationResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.UpdateLocationRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.UpdateLocationResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.AnyTimeInterrogationRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.AnyTimeInterrogationResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.InsertSubscriberDataRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.InsertSubscriberDataResponse;
import org.mobicents.protocols.ss7.tcap.asn.ApplicationContextName;
import org.mobicents.protocols.ss7.tcap.asn.comp.Problem;

public class MAPListener implements MAPDialogListener, MAPServiceMobilityListener {

	private static final Logger logger = Logger.getLogger(MAPListener.class);

	private MAPSimulator iHubManagement = null;

	private final MAPErrorMessageFactory mAPErrorMessageFactory;

	protected MAPListener(MAPSimulator iHubManagement) {
		this.iHubManagement = iHubManagement;
		this.mAPErrorMessageFactory = this.iHubManagement.getMapProvider().getMAPErrorMessageFactory();
	}

	@Override
	public void onErrorComponent(MAPDialog arg0, Long arg1, MAPErrorMessage arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInvokeTimeout(MAPDialog arg0, Long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMAPMessage(MAPMessage arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnyTimeInterrogationRequest(AnyTimeInterrogationRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnyTimeInterrogationResponse(AnyTimeInterrogationResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCheckImeiRequest(CheckImeiRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCheckImeiResponse(CheckImeiResponse checkImeiResponse) {
		logger.info("MAPListener.onCheckImeiResponse");
		
		logger.info("DialogId: " + checkImeiResponse.getMAPDialog().getLocalDialogId() + ". EquipmentStatus: " + checkImeiResponse.getEquipmentStatus());
	}

	@Override
	public void onSendAuthenticationInfoRequest(
			SendAuthenticationInfoRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSendAuthenticationInfoResponse(
			SendAuthenticationInfoResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpdateLocationRequest(UpdateLocationRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpdateLocationResponse(UpdateLocationResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDialogAccept(MAPDialog arg0, MAPExtensionContainer arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDialogClose(MAPDialog arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDialogDelimiter(MAPDialog arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDialogNotice(MAPDialog arg0, MAPNoticeProblemDiagnostic arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDialogProviderAbort(MAPDialog arg0,
			MAPAbortProviderReason arg1, MAPAbortSource arg2,
			MAPExtensionContainer arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDialogRelease(MAPDialog arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDialogRequest(MAPDialog arg0, AddressString arg1,
			AddressString arg2, MAPExtensionContainer arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDialogRequestEricsson(MAPDialog arg0, AddressString arg1,
			AddressString arg2, IMSI arg3, AddressString arg4) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDialogTimeout(MAPDialog arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDialogUserAbort(MAPDialog arg0, MAPUserAbortChoice arg1,
			MAPExtensionContainer arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCancelLocationRequest(CancelLocationRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCancelLocationResponse(CancelLocationResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRejectComponent(MAPDialog arg0, Long arg1, Problem arg2, boolean arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInsertSubscriberDataRequest(InsertSubscriberDataRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInsertSubscriberDataResponse(InsertSubscriberDataResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDialogReject(MAPDialog arg0, MAPRefuseReason arg1, ApplicationContextName arg2,
			MAPExtensionContainer arg3) {
		// TODO Auto-generated method stub
		
	}

}
