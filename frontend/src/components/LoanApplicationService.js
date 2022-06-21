import http from '../components/http-common'

export const LoanApplicationService = {
    getAll() {
        return http.get("/loanApplication")
    },
    create(data) {
        return http.post('/loanApplication', data)
    } ,  
    updateApproved(id, data) {
        return http.put(`/loanApplication/${id}`, data)
    },
    updateRejected(id, data) {
        return http.put(`/loanApplication/${id}`, data)
    }
}