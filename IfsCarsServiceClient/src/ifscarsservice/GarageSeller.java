/**
 * GarageSeller.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ifscarsservice;

public interface GarageSeller extends java.rmi.Remote {
    public void consultCarPricesAndAvailability() throws java.rmi.RemoteException;
    public void purchaseCar(java.lang.String basket, java.lang.String rib, java.lang.String currency, double price) throws java.rmi.RemoteException;
}
