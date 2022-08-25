import { BaseService, ErrorWrapper, ResponseWrapper } from './base.js'
import axios from 'axios'

export class PlanServices extends BaseService{
    static get entity () {
        return 'trip'
    }

    static async createPlan(param, wallet_principal) {
      try {
        const response = await this.request({ auth: false }).post(`${this.entity}/generate`,
        {
          "walletId" : wallet_principal,
          "destination":param.destination,
          "budget": param.budget,
          "startDate": param.startDate,
          "endDate": param.endDate
        })
        console.log("response: " + response)
        return new ResponseWrapper(response, response.config.data)
      } catch (error) {
        throw new ErrorWrapper(error)
      }
    }
}