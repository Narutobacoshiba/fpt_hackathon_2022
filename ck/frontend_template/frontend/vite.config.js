import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue()],
    resolve: {
        alias: {
            '@': fileURLToPath(new URL('./src',
                import.meta.url))
        }
    },
    server: {
        fs: {
            allow: ["."],
        },
        proxy: {
            // This proxies all http requests made to /api to our running dfx instance
            "^/bapi": {
                target: "http://127.0.0.1:8080",
                changeOrigin: true,
                secure: false,
                pathRewrite: { '^/bapi': '' },
            }
        },

    },
})