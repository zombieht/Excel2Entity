package cc.aicode.e2e.Excel2Entity;

import cc.aicode.e2e.annotation.ExcelEntity;
import cc.aicode.e2e.annotation.ExcelProperty;

/**
 * 功能说明： 测试例子
 * 参数说明：
 *
 * @author 管宜尧
 * 2013-11-28 下午8:05:04
 */
@ExcelEntity
public class Demo {
    @ExcelProperty(value = "NAME")
    private String name;

    @ExcelProperty(value = "CJK")
    private String cjk;

    @ExcelProperty(value = "ETB")
    private String etb;

    @ExcelProperty(value = "ETD")
    private String etd;

    @ExcelProperty(value = "CARGO")
    private String cargo;

    @ExcelProperty(value = "QUANTITY")
    private String quantity;

    @ExcelProperty(value = "LAST PORT")
    private String lastProt;

    @ExcelProperty(value = "LOA")
    private String loa;

    public Demo() {
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

    public String getLastProt() {
        return lastProt;
    }

    public void setLastProt(String lastProt) {
        this.lastProt = lastProt;
    }

    public String getLoa() {
        return loa;
    }

    public void setLoa(String loa) {
        this.loa = loa;
    }
}
