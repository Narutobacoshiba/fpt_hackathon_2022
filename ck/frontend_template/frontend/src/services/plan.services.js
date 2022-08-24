import { BaseService, ErrorWrapper, ResponseWrapper } from './base.js'

export class PlanServices extends BaseService{
    static get entity () {
        return 'trip'
    }

    static async createPlan(param) {
      try {
        const response = await axios.get("/bapi/trip/generate", {
          params: param,
        })
        // const responses = await axios.get("/dapi/trip/generate", {
        //   params: param,
        // })
        //const response = await this.request({ auth: false }).post(`${this.entity}/generate`,{"param":param})
        return new ResponseWrapper(response, response.data)
      } catch (error) {
        throw new ErrorWrapper(error)
      }
    }
}