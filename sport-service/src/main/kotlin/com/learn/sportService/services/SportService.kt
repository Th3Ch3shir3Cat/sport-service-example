package com.learn.sportService.services
import com.learn.openapi.sport.models.Sport
import com.learn.openapi.sport.models.SportBody
import com.learn.sportService.mappers.SportMapper
import com.learn.sportService.repositories.SportRepository
import org.springframework.stereotype.Service

@Service
class SportService (
    private val sportMapper : SportMapper,
    private val sportRepository: SportRepository) {

    fun getAllSports(): List<Sport> {
        return sportRepository.findAll().map { sportMapper.mapSport(it) }
    }


    fun createSport(sportBody: SportBody): Sport {
        if(!sportRepository.findByName(sportBody.name.lowercase()).isPresent){
            val sport = sportRepository.save(sportMapper.mapSport(sportBody))
            return sportMapper.mapSport(sport)
        }
        throw IllegalArgumentException("Sport with name ${sportBody.name.lowercase()} already exists")
    }
}