package application.modal;

public class Pessoa {

	 private String name, cpf;
	 private Integer age;
	 private String phone, address;
	 
	 public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(String name, String cpf, Integer age, String phone, String address) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Pessoa [name=" + name + ", cpf=" + cpf + ", age=" + age + ", phone=" + phone + ", address=" + address
				+ "]";
	}
	 
	 
	
}
