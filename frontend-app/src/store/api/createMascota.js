export const createPet = async (datas) => {
    try {
        const url = ""
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datas)
        })
        console.log(response)
    } catch (error) {
        console.log(error)
    }
}