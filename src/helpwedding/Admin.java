package helpwedding;

	//Admin merupakan class
	public class Admin {
        private String username;
        private String password;

		Admin(){
	        
	    }
	
	//method class Admin 

	public int login(String username, String password){     //method
		if("admin".equals(username) && "login123".equals(password)){
			System.out.println("Anda berhasil login! \n");
			return 1;
		}
		else{
			System.out.println("Username atau password Anda salah! \n");
			return 0;
		}
	}


}

