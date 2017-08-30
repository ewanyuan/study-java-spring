package wsClient;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.sound.midi.Soundbank;
import java.rmi.RemoteException;

/**
 * Created by ewan on 30/08/2017.
 */
public class Client {
    public static void main(String[] args) throws RemoteException {
        CGzglWebServiceStub.ExecSIGService2 service = new CGzglWebServiceStub.ExecSIGService2();
        service.setStype("010");
        service.setDwlx("rzxx");
        service.setJsonString("{\"GMSFHM\":\"dsdfsd\"}");
        CGzglWebServiceStub.ExecSIGService2Response a = new CGzglWebServiceStub().execSIGService2(service);
        System.out.println(a.getExecSIGService2Result());
    }
}
