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
import org.mobicents.protocols.ss7.map.api.service.mobility.authentication.AuthenticationFailureReportRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.authentication.AuthenticationFailureReportResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.authentication.SendAuthenticationInfoRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.authentication.SendAuthenticationInfoResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.faultRecovery.ForwardCheckSSIndicationRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.faultRecovery.ResetRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.faultRecovery.RestoreDataRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.faultRecovery.RestoreDataResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.imei.CheckImeiRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.imei.CheckImeiResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.CancelLocationRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.CancelLocationResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.PurgeMSRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.PurgeMSResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.SendIdentificationRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.SendIdentificationResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.UpdateGprsLocationRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.UpdateGprsLocationResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.UpdateLocationRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.locationManagement.UpdateLocationResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.oam.ActivateTraceModeRequest_Mobility;
import org.mobicents.protocols.ss7.map.api.service.mobility.oam.ActivateTraceModeResponse_Mobility;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.AnyTimeInterrogationRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.AnyTimeInterrogationResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.ProvideSubscriberInfoRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.ProvideSubscriberInfoResponse;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.DeleteSubscriberDataRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.DeleteSubscriberDataResponse;
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
	public void onErrorComponent(MAPDialog mapDialog, Long invokeId, MAPErrorMessage mapErrorMessage) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onInvokeTimeout(MAPDialog mapDialog, Long invokeId) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onMAPMessage(MAPMessage mapMessage) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onAnyTimeInterrogationRequest(AnyTimeInterrogationRequest anyTimeInterrogationRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onAnyTimeInterrogationResponse(AnyTimeInterrogationResponse anyTimeInterrogationResponse) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCheckImeiRequest(CheckImeiRequest checkImeiRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onCheckImeiResponse(CheckImeiResponse checkImeiResponse) {
		logger.info("MAPListener.onCheckImeiResponse");

		logger.info("DialogId: " + checkImeiResponse.getMAPDialog().getLocalDialogId() + ". EquipmentStatus: " + checkImeiResponse.getEquipmentStatus());
	}

	@Override
	public void onSendAuthenticationInfoRequest(SendAuthenticationInfoRequest sendAuthenticationInfoRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onSendAuthenticationInfoResponse(SendAuthenticationInfoResponse sendAuthenticationInfoResponse) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onUpdateLocationRequest(UpdateLocationRequest updateLocationRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onUpdateLocationResponse(UpdateLocationResponse updateLocationResponse) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDialogAccept(MAPDialog mapDialog, MAPExtensionContainer extensionContainer) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDialogClose(MAPDialog mapDialog) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDialogDelimiter(MAPDialog mapDialog) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDialogNotice(MAPDialog mapDialog, MAPNoticeProblemDiagnostic noticeProblemDiagnostic) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDialogProviderAbort(MAPDialog mapDialog, MAPAbortProviderReason abortProviderReason,
	        MAPAbortSource abortSource, MAPExtensionContainer extensionContainer) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDialogRelease(MAPDialog mapDialog) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDialogRequest(MAPDialog mapDialog, AddressString destReference, AddressString origReference,
            MAPExtensionContainer extensionContainer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDialogRequestEricsson(MAPDialog mapDialog, AddressString destReference, AddressString origReference,
            IMSI eriImsi, AddressString eriVlrNo) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDialogTimeout(MAPDialog mapDialog) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDialogUserAbort(MAPDialog mapDialog, MAPUserAbortChoice userReason, MAPExtensionContainer extensionContainer) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onCancelLocationRequest(CancelLocationRequest cancelLocationRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onCancelLocationResponse(CancelLocationResponse cancelLocationResponse) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onRejectComponent(MAPDialog mapDialog, Long invokeId, Problem problem, boolean isLocalOriginated) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onInsertSubscriberDataRequest(InsertSubscriberDataRequest insertSubscriberDataRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onInsertSubscriberDataResponse(InsertSubscriberDataResponse insertSubscriberDataResponse) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDialogReject(MAPDialog mapDialog, MAPRefuseReason refuseReason, ApplicationContextName alternativeApplicationContext, MAPExtensionContainer extensionContainer) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onPurgeMSRequest(PurgeMSRequest purgeMSRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onPurgeMSResponse(PurgeMSResponse purgeMSResponse) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onSendIdentificationRequest(SendIdentificationRequest sendIdentificationRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onSendIdentificationResponse(SendIdentificationResponse sendIdentificationResponse) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onUpdateGprsLocationRequest(UpdateGprsLocationRequest updateGprsLocationRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onUpdateGprsLocationResponse(UpdateGprsLocationResponse updateGprsLocationResponse) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onAuthenticationFailureReportRequest(AuthenticationFailureReportRequest authenticationFailureReportRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onAuthenticationFailureReportResponse(AuthenticationFailureReportResponse authenticationFailureReportResponse) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onResetRequest(ResetRequest resetRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onForwardCheckSSIndicationRequest(ForwardCheckSSIndicationRequest forwardCheckSSIndicationRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onRestoreDataRequest(RestoreDataRequest restoreDataRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onRestoreDataResponse(RestoreDataResponse restoreDataResponse) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onProvideSubscriberInfoRequest(ProvideSubscriberInfoRequest provideSubscriberInfoRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onProvideSubscriberInfoResponse(ProvideSubscriberInfoResponse provideSubscriberInfoResponse) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDeleteSubscriberDataRequest(DeleteSubscriberDataRequest deleteSubscriberDataRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDeleteSubscriberDataResponse(DeleteSubscriberDataResponse deleteSubscriberDataResponse) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onActivateTraceModeRequest_Mobility(ActivateTraceModeRequest_Mobility activateTraceModeRequest_Mobility) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onActivateTraceModeResponse_Mobility(ActivateTraceModeResponse_Mobility activateTraceModeResponse_Mobility) {
		// TODO Auto-generated method stub
	}

}
