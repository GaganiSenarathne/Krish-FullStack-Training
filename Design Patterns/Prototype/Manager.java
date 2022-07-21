public class Manager extends Member {
	
	private String seniority;

	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

	@Override
	public String toString() {
		return "Manager [seniority=" + seniority + "]";
	}
	

}