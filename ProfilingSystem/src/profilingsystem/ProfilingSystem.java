package profilingsystem;

public class ProfilingSystem {

    public static void main(String[] args) {
        
        Splash splash = new Splash();
        splash.setVisible(true);
        try {
            
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(60);
                splash.count.setText(Integer.toString(i)+"%");
                splash.progress.setValue(i);
                
                if(i==100) {
                    
                    splash.setVisible(false);
                    new Login().setVisible(true);
                    
                }
            }
        } 
        
        catch (Exception e) {
            
            System.out.println("Error");
        }
        
    }
    
}
