package library

import java.time.LocalDate

class BootStrap {
    
    def fixtureService

    def init = { servletContext ->
       fixtureService.loaddata()
    }

    def destroy = {
    }
}