package ifscarsservice;

public class GarageSellerProxy implements ifscarsservice.GarageSeller {
  private String _endpoint = null;
  private ifscarsservice.GarageSeller garageSeller = null;
  
  public GarageSellerProxy() {
    _initGarageSellerProxy();
  }
  
  public GarageSellerProxy(String endpoint) {
    _endpoint = endpoint;
    _initGarageSellerProxy();
  }
  
  private void _initGarageSellerProxy() {
    try {
      garageSeller = (new ifscarsservice.GarageSellerServiceLocator()).getGarageSeller();
      if (garageSeller != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)garageSeller)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)garageSeller)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (garageSeller != null)
      ((javax.xml.rpc.Stub)garageSeller)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ifscarsservice.GarageSeller getGarageSeller() {
    if (garageSeller == null)
      _initGarageSellerProxy();
    return garageSeller;
  }
  
  public void consultCarPricesAndAvailability() throws java.rmi.RemoteException{
    if (garageSeller == null)
      _initGarageSellerProxy();
    garageSeller.consultCarPricesAndAvailability();
  }
  
  public void purchaseCar(java.lang.String basket, java.lang.String rib, java.lang.String currency, double price) throws java.rmi.RemoteException{
    if (garageSeller == null)
      _initGarageSellerProxy();
    garageSeller.purchaseCar(basket, rib, currency, price);
  }
  
  
}