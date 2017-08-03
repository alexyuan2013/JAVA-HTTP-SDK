package com.cmiot.onenet;

import org.json.JSONObject;

import cmcc.iot.onenet.javasdk.api.cmds.QueryCmdsRespApi;
import cmcc.iot.onenet.javasdk.api.cmds.QueryCmdsStatus;
import cmcc.iot.onenet.javasdk.api.cmds.SendCmdsApi;
import cmcc.iot.onenet.javasdk.api.datastreams.GetDatastreamApi;
import cmcc.iot.onenet.javasdk.exception.OnenetApiException;
import cmcc.iot.onenet.javasdk.response.BasicResponse;
import cmcc.iot.onenet.javasdk.response.cmds.CmdsResponse;
import cmcc.iot.onenet.javasdk.response.cmds.NewCmdsResponse;
import cmcc.iot.onenet.javasdk.response.datastreams.DatastreamsResponse;

public class TestOneNet {
	
	public static String sendCmd() {
		String devId = "10276326";
		String key = "HM9fbweWQ00NzRUsWDdgrPHJnB8=";
		String text = "{\"msgType\":0,\"cmdType\":1,\"SN\":\"113335500\"}";
		SendCmdsApi api = new SendCmdsApi("10276326", null, null, null, text, key);
		BasicResponse<NewCmdsResponse> response = api.executeApi();
		//System.out.println(response.getData().getCmduuid());
		return response.getData().getCmduuid();
	}
	
	public static void getCmd(String cmdUuid) {
		String key = "HM9fbweWQ00NzRUsWDdgrPHJnB8=";		
		QueryCmdsStatus apiStatus = new QueryCmdsStatus(cmdUuid,key);
		BasicResponse<CmdsResponse> res = apiStatus.executeApi();
		System.out.println(res.getJson());
		while(res.getErrno() == 0) {
			CmdStatus status = JSONObject.parseObject(res.getJson(), CmdStatus.class);
			if (status.getData().getStatus() == 4) {
				break;
			} else {
				res = apiStatus.executeApi();
			}
		}
		System.out.println(res.getJson());
		try {
			QueryCmdsRespApi api=new QueryCmdsRespApi(cmdUuid,key);
			String response = api.executeApi();
			System.out.println(response);
		} catch (OnenetApiException e) {
		}
		//System.out.println(response);
	}
	
	public static void main(String[] args) {
//		GetDatastreamApi getData = new GetDatastreamApi("10276326", "REPORT_STATE", "HM9fbweWQ00NzRUsWDdgrPHJnB8=");
//		BasicResponse<DatastreamsResponse> response = getData.executeApi();
//		System.out.println("errno:"+response.errno+" error:"+response.error);
//		System.out.println(response.getData().getCurrentValue());
//		System.out.println(response.getData().getCreateTime());
		String cmd = sendCmd();
		//String cmd = "f1cacbd9-9b85-537f-89d7-1281d4265b87";
		System.out.println(cmd);
		getCmd(cmd);
	}

}
