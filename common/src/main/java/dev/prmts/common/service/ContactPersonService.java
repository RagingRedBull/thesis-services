package dev.prmts.common.service;

import dev.prmts.common.model.entity.ContactPerson;
import dev.prmts.common.repository.ContactPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactPersonService {
    private final ContactPersonRepository contactPersonRepository;

    public List<ContactPerson> findAll() {
        return contactPersonRepository.findAll();
    }

}
