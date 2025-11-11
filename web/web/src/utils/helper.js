export const buildURL = (filename) => new URL(filename, import.meta.env.APP_BASE_URL).href
