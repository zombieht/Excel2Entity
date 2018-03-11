package cc.aicode.e2e.Excel2Entity;

import cc.aicode.e2e.annotation.ExcelEntity;
import cc.aicode.e2e.annotation.ExcelProperty;

import javax.persistence.*;

/**
 * 功能说明： 测试例子
 * 参数说明：
 *
 * 2013-11-28 下午8:05:04
 */
@ExcelEntity
@Entity
@Table(name = "excel")
public class Demo {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ExcelProperty(value = "NAME")
    @Column(name = "name")
    private String name;

    @ExcelProperty(value = "CJK")
    @Column(name = "cjk")
    private String cjk;

    @ExcelProperty(value = "ETB")
    @Column(name = "etb")
    private String etb;

    @ExcelProperty(value = "ETD")
    @Column(name = "etd")
    private String etd;

    @ExcelProperty(value = "CARGO")
    @Column(name = "cargo")
    private String cargo;

    @ExcelProperty(value = "QUANTITY")
    @Column(name = "quantity")
    private String quantity;

    @ExcelProperty(value = "LAST PORT")
    @Column(name = "last_port")
    private String lastPort;

    @ExcelProperty(value = "LOA")
    @Column(name = "loa")
    private String loa;

    public Demo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCjk() {
        return cjk;
    }

    public void setCjk(String cjk) {
        this.cjk = cjk;
    }

    public String getEtb() {
        return etb;
    }

    public void setEtb(String etb) {
        this.etb = etb;
    }

    public String getEtd() {
        return etd;
    }

    public void setEtd(String etd) {
        this.etd = etd;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getLastPort() {
        return lastPort;
    }

    public void setLastPort(String lastPort) {
        this.lastPort = lastPort;
    }

    public String getLoa() {
        return loa;
    }

    public void setLoa(String loa) {
        this.loa = loa;
    }
}
