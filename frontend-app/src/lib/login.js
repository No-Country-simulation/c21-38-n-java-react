export async function login(email, password) {
    try {
        const response = await fetch(`https://c21-38-n-java-react-production.up.railway.app/api/auth/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({'email': email, 'password': password})
        })
        console.log(response)
    } catch (error) {
        console.log(error)
    }
}