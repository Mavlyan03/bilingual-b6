package kg.peaksoft.bilingualb6.service;

import kg.peaksoft.bilingualb6.dto.response.SimpleResponse;
import kg.peaksoft.bilingualb6.entites.Option;
import kg.peaksoft.bilingualb6.exceptions.NotFoundException;
import kg.peaksoft.bilingualb6.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class OptionService {

    private final OptionRepository optionRepository;

    public SimpleResponse deleteOption(Long id) {
        Option option = optionRepository.findOptionById(id);
        if (option != null) {
            optionRepository.updateByIdForDelete(id);
            optionRepository.deleteById(id);
        }
        return new SimpleResponse("option with id: " + id + " is deleted","DELETE");
    }
}
