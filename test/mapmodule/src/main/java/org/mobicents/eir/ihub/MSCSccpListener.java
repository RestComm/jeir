package org.mobicents.eir.ihub;

import org.apache.log4j.Logger;
import org.mobicents.protocols.ss7.indicator.NatureOfAddress;
import org.mobicents.protocols.ss7.indicator.NumberingPlan;
import org.mobicents.protocols.ss7.indicator.RoutingIndicator;
import org.mobicents.protocols.ss7.map.api.MAPApplicationContext;
import org.mobicents.protocols.ss7.map.api.MAPApplicationContextName;
import org.mobicents.protocols.ss7.map.api.MAPApplicationContextVersion;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.MAPParameterFactory;
import org.mobicents.protocols.ss7.map.api.MAPProvider;
import org.mobicents.protocols.ss7.map.api.primitives.IMEI;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.service.mobility.MAPDialogMobility;
import org.mobicents.protocols.ss7.sccp.RemoteSccpStatus;
import org.mobicents.protocols.ss7.sccp.SccpListener;
import org.mobicents.protocols.ss7.sccp.SignallingPointStatus;
import org.mobicents.protocols.ss7.sccp.message.SccpDataMessage;
import org.mobicents.protocols.ss7.sccp.message.SccpNoticeMessage;
import org.mobicents.protocols.ss7.sccp.parameter.GT0100;
import org.mobicents.protocols.ss7.sccp.parameter.SccpAddress;

public class MSCSccpListener implements SccpListener {

	private static final Logger logger = Logger.getLogger(MSCSccpListener.class);
	
	private static final String GT_MSC = "553496629938";
	private static final String GT_EIR = "553496629939";
	
	private static final int PC_MSC = 8;
	private static final int PC_EIR = 9;
	
	private MAPProvider mapProvider;
	
	private SccpAddress thisAddress;
	private SccpAddress remoteAddress;
	
	public MSCSccpListener(MAPProvider mapProvider) {
		this.mapProvider = mapProvider;
	}
	
	@Override
	public void onPcState(int arg0, SignallingPointStatus arg1, int arg2, RemoteSccpStatus arg3) {
		logger.info("Connection created. Send checkIMEI request to EIR");
		
		try {
			//TODO: Should read from a file the IMEIs and IMSIs to test.
			for (int i = 0; i < 3; i++) {
				String testIMEI = "33333333444444" + i;
				String testIMSI = "11111111222222" + i;
				MAPDialogMobility clientDialogMobility = setupCheckImeiRequest(testIMEI, testIMSI);
				clientDialogMobility.send();
			}
		} catch (MAPException e) {
			logger.error("Error sending checkImei request", e);
		}
	}
	
	private MAPDialogMobility setupCheckImeiRequest(String testIMEI, String testIMSI) throws MAPException {
		MAPDialogMobility clientDialogMobility = this.mapProvider.getMAPServiceMobility()
				.createNewDialog(getApplicationContext(), getMSCSccpAddress(), null, getEIRSccpAddress(), null);
		
		logger.info("DialogId: " + clientDialogMobility.getDialogId() + ". Sending IMEI=[" + testIMEI + "]. IMSI=[" + testIMSI + "]");
		MAPParameterFactory mapParameterFactory = this.mapProvider.getMAPParameterFactory();
		IMEI imei = mapParameterFactory.createIMEI(testIMEI);
		IMSI imsi = mapParameterFactory.createIMSI(testIMSI);
	
		clientDialogMobility.addCheckImeiRequest_Huawei(imei, null, null, imsi);
		
		return clientDialogMobility;
	}
	
	private SccpAddress getMSCSccpAddress() {
		if (this.thisAddress == null) {
			GT0100 gt = new GT0100(0, NumberingPlan.ISDN_TELEPHONY, NatureOfAddress.INTERNATIONAL, GT_MSC);
			this.thisAddress = new SccpAddress(RoutingIndicator.ROUTING_BASED_ON_GLOBAL_TITLE, 0, gt, PC_MSC);
		}
		return this.thisAddress;
	}
	
	private SccpAddress getEIRSccpAddress() {
		if (this.remoteAddress == null) {
			GT0100 gt = new GT0100(0, NumberingPlan.ISDN_TELEPHONY, NatureOfAddress.INTERNATIONAL, GT_EIR);
			this.remoteAddress = new SccpAddress(RoutingIndicator.ROUTING_BASED_ON_GLOBAL_TITLE, 0, gt, PC_EIR);
		}
		return this.remoteAddress;
	}
	
	private MAPApplicationContext getApplicationContext() {
		return MAPApplicationContext.getInstance(MAPApplicationContextName.equipmentMngtContext, MAPApplicationContextVersion.version2);
	}

	@Override
	public void onCoordRequest(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCoordResponse(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(SccpDataMessage arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNotice(SccpNoticeMessage arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onState(int arg0, int arg1, boolean arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

}
