import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

public class Registry {
	
	private Map<MemberType, Member> member = new HashMap<>();

	public Registry() {
		
		initialize();
		
	}
	
    public Member getMembers(MemberType memberType) {
    	Member mem = null;
    	try {
			mem = (Member) member.get(memberType).clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return mem;
    }

	private void initialize() {
		
		CEO ceo = new CEO();
		ceo.setName("John");
		ceo.setAge(35);
		ceo.setexperience("18 Years");
	
		Manager manager = new Manager();
		manager.setName("Jane");
		manager.setAge(26);
		manager.setSeniority("Prefect");
		
		member.put(MemberType.CEO, ceo);
		member.put(MemberType.MANAGER, manager);
	}

	
	
	

}