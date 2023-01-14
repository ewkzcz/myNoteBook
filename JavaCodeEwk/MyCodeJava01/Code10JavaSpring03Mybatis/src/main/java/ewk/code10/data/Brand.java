package ewk.code10.data;

public class Brand {
    private Integer id;
    private String brandName;
    private String enterpriseName;
    private String introduce;

    public Brand(Integer id, String brandName, String enterpriseName, String introduce) {
        this.id = id;
        this.brandName = brandName;
        this.enterpriseName = enterpriseName;
        this.introduce = introduce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", introduce='" + introduce + '\'' +
                '}' + '\n';
    }
}
