
package it.car2go.servant.prenotazione;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PrenotazioneServant", targetNamespace = "http://prenotazione.servant.car2go.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PrenotazioneServant {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<it.car2go.servant.prenotazione.Prenotazione>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPrenotazioniByUserId", targetNamespace = "http://prenotazione.servant.car2go.it/", className = "it.car2go.servant.prenotazione.GetPrenotazioniByUserId")
    @ResponseWrapper(localName = "getPrenotazioniByUserIdResponse", targetNamespace = "http://prenotazione.servant.car2go.it/", className = "it.car2go.servant.prenotazione.GetPrenotazioniByUserIdResponse")
    @Action(input = "http://prenotazione.servant.car2go.it/PrenotazioneServant/getPrenotazioniByUserIdRequest", output = "http://prenotazione.servant.car2go.it/PrenotazioneServant/getPrenotazioniByUserIdResponse")
    public List<Prenotazione> getPrenotazioniByUserId(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @return
     *     returns java.util.List<it.car2go.servant.prenotazione.Prenotazione>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPrenotazioni", targetNamespace = "http://prenotazione.servant.car2go.it/", className = "it.car2go.servant.prenotazione.GetPrenotazioni")
    @ResponseWrapper(localName = "getPrenotazioniResponse", targetNamespace = "http://prenotazione.servant.car2go.it/", className = "it.car2go.servant.prenotazione.GetPrenotazioniResponse")
    @Action(input = "http://prenotazione.servant.car2go.it/PrenotazioneServant/getPrenotazioniRequest", output = "http://prenotazione.servant.car2go.it/PrenotazioneServant/getPrenotazioniResponse")
    public List<Prenotazione> getPrenotazioni();

    /**
     * 
     * @param arg0
     * @return
     *     returns it.car2go.servant.prenotazione.Prenotazione
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPrenotazione", targetNamespace = "http://prenotazione.servant.car2go.it/", className = "it.car2go.servant.prenotazione.GetPrenotazione")
    @ResponseWrapper(localName = "getPrenotazioneResponse", targetNamespace = "http://prenotazione.servant.car2go.it/", className = "it.car2go.servant.prenotazione.GetPrenotazioneResponse")
    @Action(input = "http://prenotazione.servant.car2go.it/PrenotazioneServant/getPrenotazioneRequest", output = "http://prenotazione.servant.car2go.it/PrenotazioneServant/getPrenotazioneResponse")
    public Prenotazione getPrenotazione(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "addPrenotazione", targetNamespace = "http://prenotazione.servant.car2go.it/", className = "it.car2go.servant.prenotazione.AddPrenotazione")
    @ResponseWrapper(localName = "addPrenotazioneResponse", targetNamespace = "http://prenotazione.servant.car2go.it/", className = "it.car2go.servant.prenotazione.AddPrenotazioneResponse")
    @Action(input = "http://prenotazione.servant.car2go.it/PrenotazioneServant/addPrenotazioneRequest", output = "http://prenotazione.servant.car2go.it/PrenotazioneServant/addPrenotazioneResponse")
    public void addPrenotazione(
        @WebParam(name = "arg0", targetNamespace = "")
        Prenotazione arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "delPrenotazione", targetNamespace = "http://prenotazione.servant.car2go.it/", className = "it.car2go.servant.prenotazione.DelPrenotazione")
    @ResponseWrapper(localName = "delPrenotazioneResponse", targetNamespace = "http://prenotazione.servant.car2go.it/", className = "it.car2go.servant.prenotazione.DelPrenotazioneResponse")
    @Action(input = "http://prenotazione.servant.car2go.it/PrenotazioneServant/delPrenotazioneRequest", output = "http://prenotazione.servant.car2go.it/PrenotazioneServant/delPrenotazioneResponse")
    public void delPrenotazione(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getLastIdPrenotazione", targetNamespace = "http://prenotazione.servant.car2go.it/", className = "it.car2go.servant.prenotazione.GetLastIdPrenotazione")
    @ResponseWrapper(localName = "getLastIdPrenotazioneResponse", targetNamespace = "http://prenotazione.servant.car2go.it/", className = "it.car2go.servant.prenotazione.GetLastIdPrenotazioneResponse")
    @Action(input = "http://prenotazione.servant.car2go.it/PrenotazioneServant/getLastIdPrenotazioneRequest", output = "http://prenotazione.servant.car2go.it/PrenotazioneServant/getLastIdPrenotazioneResponse")
    public int getLastIdPrenotazione(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "updatePrenotazione", targetNamespace = "http://prenotazione.servant.car2go.it/", className = "it.car2go.servant.prenotazione.UpdatePrenotazione")
    @ResponseWrapper(localName = "updatePrenotazioneResponse", targetNamespace = "http://prenotazione.servant.car2go.it/", className = "it.car2go.servant.prenotazione.UpdatePrenotazioneResponse")
    @Action(input = "http://prenotazione.servant.car2go.it/PrenotazioneServant/updatePrenotazioneRequest", output = "http://prenotazione.servant.car2go.it/PrenotazioneServant/updatePrenotazioneResponse")
    public void updatePrenotazione(
        @WebParam(name = "arg0", targetNamespace = "")
        Prenotazione arg0);

}
