package con.stone.service;

import con.stone.dto.LaptopDto;
import con.stone.dto.PersonDto;
import con.stone.entity.Laptop;
import con.stone.entity.Person;
import con.stone.repository.LaptopRepository;

import java.util.ArrayList;
import java.util.List;

public class LaptopServiceImpl implements LaptopService{
    private LaptopRepository repository=null;

    public LaptopServiceImpl(LaptopRepository repository) {
        this.repository=repository;
    }

    @Override
    public LaptopDto findOne(Integer integer) {
        Laptop laptop=repository.findOne(integer);
        return new LaptopDto(laptop);
    }

    @Override
    public LaptopDto save(LaptopDto entity) {
        Laptop laptop=repository.save(entity.getEntity());
        return new LaptopDto(laptop);
    }

    @Override
    public LaptopDto update(LaptopDto entity) {
        return null;
    }

    @Override
    public void delete(LaptopDto entity) {

    }

    @Override
    public void deleteById(Integer integer) {

    }


    @Override
    public List<LaptopDto> findAll() {

        List<Laptop> laptopList=repository.findAll();
        List<LaptopDto> laptopDtoList =null;
        for (Laptop laptop:laptopList){
            if (laptopDtoList==null){
                laptopDtoList=new ArrayList<>();
            }
            LaptopDto dto=new LaptopDto(laptop);
            laptopDtoList.add(dto);
        }
        return laptopDtoList;
    }
}
