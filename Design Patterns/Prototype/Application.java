public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Registry registry = new Registry();
		
		Manager manager = (Manager) registry.getMembers(MemberType.MANAGER);
		System.out.println(manager);

	}

}