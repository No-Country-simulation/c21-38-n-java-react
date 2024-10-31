import { create } from 'zustand'
import { deleteTokenCookie, getTokenCookie } from '../../lib/cookiesSession'

export const useLogin = create()((set) => ({
    login: false,
    infoUser: {},
    typeUser: "",
    token: "",
    loginSession: (setToken) => set({login: true, token: setToken}),
    initSession: (user, setToken, setTypeUser) => set({login: true, infoUser: user, token: setToken, typeUser: setTypeUser}),
    closeSession: () => {
        deleteTokenCookie()
        set({login: false, typeUser: ""})
    },
    checkSession: () => {
        const token = getTokenCookie()
        if (token) {
            const base64payload = token.split(".")[1]
            const payload = atob(base64payload)
            const setPayload = JSON.parse(payload)
            set({login: true, token: token, typeUser: setPayload.role})
        }
    }
}))