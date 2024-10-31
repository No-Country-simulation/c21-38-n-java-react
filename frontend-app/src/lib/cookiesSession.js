import Cookies from 'js-cookie'

export const setTokenCookie = (token) => {
    Cookies.set('token-session-huellitas', token, { expires: 7, path: '/'})
}

export const getTokenCookie = () => {
    return Cookies.get('token-session-huellitas')
}

export const deleteTokenCookie = () => {
    Cookies.remove('token-session-huellitas')
}