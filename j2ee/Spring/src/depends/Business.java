package depends;

public class Business{
    private IDeviceWriter writer ;
    
    public void setWriter(IDeviceWriter writer) {
	    this.writer = writer;
	}
                    
    public void save(){
       writer. saveToDervice();
   }
}
