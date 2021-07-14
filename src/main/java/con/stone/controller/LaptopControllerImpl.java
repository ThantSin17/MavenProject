package con.stone.controller;

import con.stone.dto.LaptopDto;
import con.stone.entity.Laptop;
import con.stone.service.LaptopService;
import con.stone.view.LaptopView;

import java.util.ArrayList;
import java.util.List;

public class LaptopControllerImpl extends AbstractControllerImpl<Laptop, LaptopView> implements LaptopController<Laptop> {
    LaptopService service;

    public LaptopControllerImpl(LaptopService service) {
        this.service = service;
    }

    @Override
    public Laptop findById(int id) {
        LaptopDto dto=service.findOne(id);
        return dto.getEntity();
    }

    @Override
    public List<Laptop> findAll() {
        List<LaptopDto> dtoList=service.findAll();
        List<Laptop> laptopList=new ArrayList<>();
        for (LaptopDto dto:dtoList){
            laptopList.add(dto.getEntity());
        }
        return laptopList;
    }

    @Override
    public Laptop save(Laptop model) {
        return service.save(new LaptopDto(model)).getEntity();
    }

    @Override
    public Laptop update(Laptop model) {
        return service.update(new LaptopDto(model)).getEntity();
    }

    @Override
    public void delete(Laptop model) {
        service.delete(new LaptopDto(model));
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);
    }

    @Override
    public Laptop getModel() {
        return super.getModel();
    }

    @Override
    public void setModel(Laptop laptop) {
        super.setModel(laptop);
    }

    @Override
    public LaptopView getView() {
        return super.getView();
    }

    @Override
    public void setView(LaptopView view) {
        super.setView(view);
    }

    @Override
    public void printDetails(Laptop laptop) {
        super.printDetails(laptop);
    }

    @Override
    public void printDetails(List<Laptop> laptops) {
        super.printDetails(laptops);
    }
}
