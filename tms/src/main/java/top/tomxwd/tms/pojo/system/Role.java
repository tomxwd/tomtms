package top.tomxwd.tms.pojo.system;

import java.util.List;

public class Role {
    private Integer id;

    private String roleName;
    
    private List<Integer> powers;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", powers=" + powers + "]";
	}

	public List<Integer> getPowers() {
		return powers;
	}

	public void setPowers(List<Integer> powers) {
		this.powers = powers;
	}

}