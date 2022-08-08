import { BaseService, ErrorWrapper, ResponseWrapper } from './base.js'

export class PlanServices extends BaseService{
    static get entity () {
        return 'plan'
    }

    static async createPlan(param) {
      try {
        const response = await this.request({ auth: false }).post(`${this.entity}/planning`,{"param":param})
        
        return new ResponseWrapper(response, response.data)
      } catch (error) {
        throw new ErrorWrapper(error)
      }
    }
}