import { create } from 'zustand'

export const useLogin = create()((set) => ({
    login: false,
    infoUser: {},
    typeUser: "",
    initSession: (user) => set({login: true, typeUser: user}),
    closeSession: () => set({login: false, typeUser: ""}),
}))