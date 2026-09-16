package Day9Assessment;

public class SauseExecutor {
	       Sauseimplimention s = new Sauseimplimention();
	       
	       public void exe(String key) {
	    	   if(key.equals("LAUNCH_BROWSER")) {
	    		   s.launchbrowser();
	    	   }
	    	   else if(key.equals("OPEN_URL")) {
	    		   s.openurl();
	    	   }
	    	   else if(key.equals("USERNAME")) {
	    		   s.Username();
	    	   }
	    	   else if(key.equals("PASS")) {
	    		   s.Password();
	    	   }
	    	   else if(key.equals("LBUTTON")) {
	    		   s.loginbutton();
	    	   }
	    		   
	       }
	       
	}
