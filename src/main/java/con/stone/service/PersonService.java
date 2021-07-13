package con.stone.service;

import con.stone.dao.AbstractDao;
import con.stone.dto.PersonDto;
import con.stone.entity.Person;

public interface PersonService extends AbstractDao<PersonDto,Integer> {
}
