package ewk.code16.data;

public class User {
    private String name;
    private Integer age;

    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ewk.code16.data.User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", province=" + address.getProvince() +
                ", city=" + address.getCity() +
                '}' + '\n';
    }
}
