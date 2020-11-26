/**
 * BankService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package bank;

public interface BankService extends java.rmi.Remote {
    public boolean payment(java.lang.String rib, double price, java.lang.String currency) throws java.rmi.RemoteException;
}
